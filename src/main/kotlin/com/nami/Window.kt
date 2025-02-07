package com.nami

import com.nami.scene.Scene
import com.nami.scene.SceneLaunching
import javax.swing.JFrame
import javax.swing.JPanel

class Window private constructor() : JFrame() {

    companion object {
        private var instance: Window? = null

        fun instance() = instance ?: throw IllegalStateException("Window has not been initialized.")

        fun init(): Window {
            if (instance != null)
                return instance()

            instance = Window()
            return instance()
        }
    }

    private var scene: Scene = SceneLaunching()

    init {
        title = "iNxmi.Chess"
        defaultCloseOperation = EXIT_ON_CLOSE
        isResizable = false

        setScene(SceneLaunching())

        isVisible = true
    }

    fun setScene(scene: Scene, hide: Boolean = true): Window {
        isVisible = !hide

        remove(this.scene.component())

        this.scene = scene
        add(scene.component())
        pack()
        setLocationRelativeTo(null)

        isVisible = true
        return this
    }

}