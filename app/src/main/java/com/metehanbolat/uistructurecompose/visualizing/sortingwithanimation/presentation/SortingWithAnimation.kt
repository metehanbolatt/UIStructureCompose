package com.metehanbolat.uistructurecompose.visualizing.sortingwithanimation.presentation

import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.metehanbolat.uistructurecompose.ui.theme.gray
import com.metehanbolat.uistructurecompose.ui.theme.orange

@ExperimentalFoundationApi
@Composable
fun SortingAnimation(
    sortViewModel: SortingWithAnimationViewModel = SortingWithAnimationViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gray)
            .padding(20.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Button(
            onClick = { sortViewModel.startSorting() },
            colors = ButtonDefaults.buttonColors(backgroundColor = orange),
        ) {
            Text(
                "Sort List",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }
        Button(
            onClick = { sortViewModel.listToSort.shuffle() },
            colors = ButtonDefaults.buttonColors(backgroundColor = orange),
        ) {
            Text(
                "Shuffle List",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ){
            items(
                sortViewModel.listToSort,
                key = {
                    it.id
                }
            ){
                val borderStroke = if(it.isCurrentlyCompared){
                    BorderStroke(width = 3.dp,Color.White,)
                }else{
                    BorderStroke(width = 0.dp,Color.Transparent)
                }
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(it.color, RoundedCornerShape(15.dp))
                        .border(borderStroke, RoundedCornerShape(15.dp))
                        .animateItemPlacement(
                            tween(300)
                        ),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        "${it.value}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }
            }
        }

    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun SortingAnimationPreview() {
    SortingAnimation()
}