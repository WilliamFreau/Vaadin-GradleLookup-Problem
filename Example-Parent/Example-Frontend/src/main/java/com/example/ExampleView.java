package com.example;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class ExampleView extends VerticalLayout {

    private final Div div;
    private final JavaAceComponent aceComponent;

    public ExampleView() {
        this.div = new Div();
        this.div.setText("Ace component should be below");
        this.aceComponent = new JavaAceComponent();
        this.add(this.div, this.aceComponent);
    }

}
