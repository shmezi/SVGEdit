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

public val MyIconPack.Rectangle: ImageVector
    get() {
        if (_rectangle != null) {
            return _rectangle!!
        }
        _rectangle = Builder(name = "Rectangle", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe8eaed)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(80.0f, 800.0f)
                verticalLineToRelative(-640.0f)
                horizontalLineToRelative(800.0f)
                verticalLineToRelative(640.0f)
                lineTo(80.0f, 800.0f)
                close()
                moveTo(160.0f, 720.0f)
                horizontalLineToRelative(640.0f)
                verticalLineToRelative(-480.0f)
                lineTo(160.0f, 240.0f)
                verticalLineToRelative(480.0f)
                close()
                moveTo(160.0f, 720.0f)
                verticalLineToRelative(-480.0f)
                verticalLineToRelative(480.0f)
                close()
            }
        }
        .build()
        return _rectangle!!
    }

private var _rectangle: ImageVector? = null
