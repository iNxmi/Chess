package com.nami.scene

import java.awt.Component
import javax.swing.JLabel
import javax.swing.JPanel

class SceneLaunching : JPanel(), Scene {

    init {
        val label = JLabel()
        label.text = "Launching..."
        add(label)
    }

    override fun component(): Component = this

}