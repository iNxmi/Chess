package com.nami.game.status

import com.nami.game.Move
import org.joml.Vector2i
import java.awt.Dimension
import javax.swing.*

class MoveHistory(
    model: DefaultListModel<Move> = DefaultListModel()
) : Box(BoxLayout.Y_AXIS) {

    val list = JList(model)

    val previousButton = JButton("Previous")
    val nextButton = JButton("Next")

    init {
        model.addElement(Move(Vector2i(0,0), Vector2i(1,0), Vector2i(1,0)))
        model.addElement(Move(Vector2i(0,0), Vector2i(1,0), Vector2i(1,0)))
        model.addElement(Move(Vector2i(0,0), Vector2i(1,0), Vector2i(1,0)))
        model.addElement(Move(Vector2i(0,0), Vector2i(1,0), Vector2i(1,0)))
        model.addElement(Move(Vector2i(0,0), Vector2i(1,0), Vector2i(1,0)))

        val hBox = Box.createHorizontalBox()
        hBox.add(previousButton)
        hBox.add(nextButton)

        add(list)
        add(hBox)

        preferredSize = Dimension(400, 0)
    }

}