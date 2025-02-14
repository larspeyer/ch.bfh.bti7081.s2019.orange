package ch.bfh.bti7081.model.patient;

import ch.bfh.bti7081.model.DbConnector;
import ch.bfh.bti7081.model.UnitOfWork;
import ch.bfh.bti7081.model.entities.Patient;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

/**
 * class for manipulating models
 * Methods for creating, updating & deleting belong in this class
 * Other classes can be as this example
 * @author gian.demarmels@students.bfh.ch
 */
public class PatientManipulator {
    //ToDo dependency injection for UnitOfWork
    private UnitOfWork transaction = new UnitOfWork(DbConnector.getDatabase());

    /**
     * Creates a patient object, saves it to the DB and returns the object.
     * @param name String
     * @param surname String
     * @return Patient object
     */
    public Patient build(String name, String surname){
        Patient obj = new Patient(name, surname);
        transaction.getPatientRepo().set(obj);
        transaction.commit();
        return obj;
    }

    /**
     * Deletes a patient by a given ID
     * @param entity ObjectId
     */
    public void delete(ObjectId entity) {
        Patient obj = transaction.getPatientRepo().get(entity);
        transaction.getPatientRepo().delete(obj);
        transaction.commit();
    }

    /**
     * Deletes multiple patients
     * @param entities List of patient-IDs
     */
    public void deleteMany(List<ObjectId> entities) {
        List<Patient> lst = entities.stream().map(x -> transaction.getPatientRepo().get(x)).collect(Collectors.toList());
        transaction.getPatientRepo().deleteMany(lst);
        transaction.commit();
    }
}
