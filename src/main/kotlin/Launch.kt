import com.nami.Window
import com.nami.scene.SceneGame
import com.nami.scene.SceneMenu
import javax.swing.UIManager


fun main() {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())

    Window.init().setScene(SceneMenu())
}