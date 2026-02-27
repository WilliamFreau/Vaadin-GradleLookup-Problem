package com.example;

import de.f0rce.ace.AceEditor;
import de.f0rce.ace.enums.AceMode;

public class JavaAceComponent extends AceEditor {

    public JavaAceComponent() {
        this.setMode(AceMode.java);
    }
}
