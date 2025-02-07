package com.nami.scene

import com.nami.Window
import java.awt.BorderLayout
import java.awt.Component
import javax.swing.Box
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel
import kotlin.system.exitProcess

class SceneMenu : JPanel(), Scene {

    private val labelTitle = JLabel()
    private val buttonPlay = JButton()
    private val buttonQuit = JButton()

    init {
        layout = BorderLayout()

        val vBox = Box.createVerticalBox()

        labelTitle.text = "iNxmi.Chess"
        vBox.add(labelTitle)

        buttonPlay.text = "Play"
        buttonPlay.addActionListener { Window.instance().setScene(SceneGame()) }
        vBox.add(buttonPlay)

        buttonQuit.text = "Quit"
        buttonQuit.addActionListener { exitProcess(0) }
        vBox.add(buttonQuit)

        add(vBox)
    }

    override fun component(): Component = this

}