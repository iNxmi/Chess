package com.nami.status

import java.awt.Dimension
import javax.swing.DefaultListModel
import javax.swing.JList

class MoveHistory(
    model: DefaultListModel<String> = DefaultListModel()
) : JList<String>(model) {

    init {
        model.addElement("a1 -> b2")
        model.addElement("7b -> 6f")
        preferredSize = Dimension(400, 0)
    }

}