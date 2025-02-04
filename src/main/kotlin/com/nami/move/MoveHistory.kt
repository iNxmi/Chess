package com.nami.move

import java.awt.Dimension
import javax.swing.DefaultListModel
import javax.swing.JList
import javax.swing.JPanel

class MoveHistory : JPanel() {

    private val listModel = DefaultListModel<String>()

    init {
        listModel.addElement("a1 -> b2")
        listModel.addElement("7b -> 6f")

        val list = JList(listModel)
        add(list)
        preferredSize = Dimension(400, 400)
    }

}