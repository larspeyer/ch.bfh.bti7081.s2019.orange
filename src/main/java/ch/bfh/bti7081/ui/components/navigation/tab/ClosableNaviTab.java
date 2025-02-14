package ch.bfh.bti7081.ui.components.navigation.tab;

import ch.bfh.bti7081.ui.util.UIUtils;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;

public class ClosableNaviTab extends NaviTab {

    private final Button close;

    public ClosableNaviTab(String label,
            Class<? extends Component> navigationTarget) {
        super(label, navigationTarget);
        getElement().setAttribute("closable", true);

        close = UIUtils.createButton(VaadinIcon.CLOSE, ButtonVariant.LUMO_SMALL,
                ButtonVariant.LUMO_TERTIARY);
        add(close);
    }

    public Button getCloseButton() {
        return close;
    }
}
