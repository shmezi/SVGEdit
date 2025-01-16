package lol.ezra.svgedit.assets.generated.myiconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import lol.ezra.svgedit.assets.generated.MyIconPack

public val MyIconPack.Pointer: ImageVector
    get() {
        if (_pointer != null) {
            return _pointer!!
        }
        _pointer = Builder(name = "Pointer", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe8eaed)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveToRelative(320.0f, 550.0f)
                lineToRelative(79.0f, -110.0f)
                horizontalLineToRelative(170.0f)
                lineTo(320.0f, 244.0f)
                verticalLineToRelative(306.0f)
                close()
                moveTo(551.0f, 880.0f)
                lineTo(406.0f, 568.0f)
                lineTo(240.0f, 800.0f)
                verticalLineToRelative(-720.0f)
                lineToRelative(560.0f, 440.0f)
                lineTo(516.0f, 520.0f)
                lineToRelative(144.0f, 309.0f)
                lineToRelative(-109.0f, 51.0f)
                close()
                moveTo(399.0f, 440.0f)
                close()
            }
        }
        .build()
        return _pointer!!
    }

private var _pointer: ImageVector? = null
