package com.xavijimenezmulet.shapesforjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xavijimenezmulet.shapes.BubbleShape
import com.xavijimenezmulet.shapes.CircularShape
import com.xavijimenezmulet.shapes.CutSquareShape
import com.xavijimenezmulet.shapes.DiagonalStartCutShape
import com.xavijimenezmulet.shapes.DiamondShape
import com.xavijimenezmulet.shapes.HeartShape
import com.xavijimenezmulet.shapes.LemonShape
import com.xavijimenezmulet.shapes.ParallelogramShape
import com.xavijimenezmulet.shapes.PolygonShape
import com.xavijimenezmulet.shapes.SquareShape
import com.xavijimenezmulet.shapes.StarShape
import com.xavijimenezmulet.shapes.TicketShape
import com.xavijimenezmulet.shapes.TriangleShape
import com.xavijimenezmulet.shapesforjetpackcompose.ui.theme.ShapesForJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShapesForJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Grid()
                }
            }
        }
    }
}

@Composable
fun Grid() {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2)
    ) {
        items(gridItems.size) { item ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(100.dp)
                        .clip(gridItems[item].shape)
                        .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        gridItems[item].title,
                        fontWeight = FontWeight.Bold,
                        fontSize = gridItems[item].textSize.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GridPreview() {
    ShapesForJetpackComposeTheme {
        Grid()
    }
}

private val gridItems = listOf(
    Shapes.Star,
    Shapes.Diamond,
    Shapes.Square,
    Shapes.Circle,
    Shapes.Triangle,
    Shapes.Heart,
    Shapes.Polygon,
    Shapes.Parallelogram,
    Shapes.Ticket,
    Shapes.CutSquare,
    Shapes.Lemon,
    Shapes.DiagonalStartCut,
    Shapes.Bubble
)

sealed class Shapes(val shape: Shape, val title: String, val textSize: Int = 15) {
    object Star : Shapes(shape = StarShape(5), "Star")
    object Diamond : Shapes(shape = DiamondShape, "Diamond")
    object Square : Shapes(shape = SquareShape, "Square")
    object Circle : Shapes(shape = CircularShape, "Circle")
    object Triangle : Shapes(shape = TriangleShape, "Triangle", 10)
    object Heart : Shapes(shape = HeartShape, "Heart")
    object Polygon : Shapes(shape = PolygonShape, "Polygon")
    object Parallelogram : Shapes(shape = ParallelogramShape(70f), "Parallelogram", 9)
    object Ticket : Shapes(shape = TicketShape(24f), "Ticket")
    object CutSquare : Shapes(shape = CutSquareShape, "Cut Square")
    object Lemon : Shapes(shape = LemonShape, "Lemon")
    object DiagonalStartCut : Shapes(shape = DiagonalStartCutShape, "Diagonal Start", 11)
    object Bubble : Shapes(shape = BubbleShape, "Bubble")
}