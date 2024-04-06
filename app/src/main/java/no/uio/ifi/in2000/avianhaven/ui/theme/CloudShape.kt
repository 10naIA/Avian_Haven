package no.uio.ifi.in2000.avianhaven.ui.theme

import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Path

abstract class CloudShape(
    private val radius: Dp = 20.dp // Adjust the radius as needed
) : Shape {

    fun createOutline(
        width: Float,
        height: Float,
        layoutDirection: LayoutDirection
    ): Outline {
        val path = Path()

        // Start from the top left
        path.moveTo(0f, height / 2f)

        // Draw curves for the cloud shape
        path.cubicTo(
            0f, height / 3f,
            width / 4f, height / 6f,
            width / 2f, height / 6f
        )
        path.cubicTo(
            3 * width / 4f, height / 6f,
            width, height / 3f,
            width, height / 2f
        )
        path.cubicTo(
            width, 2 * height / 3f,
            3 * width / 4f, 5 * height / 6f,
            width / 2f, 5 * height / 6f
        )
        path.cubicTo(
            width / 4f, 5 * height / 6f,
            0f, 2 * height / 3f,
            0f, height / 2f
        )

        return Outline.Generic(path)
    }
}