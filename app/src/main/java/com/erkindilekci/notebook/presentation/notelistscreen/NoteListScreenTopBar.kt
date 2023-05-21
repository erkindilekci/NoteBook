package com.erkindilekci.notebook.presentation.notelistscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erkindilekci.notebook.R
import com.erkindilekci.notebook.ui.theme.Blue700

@Composable
fun NoteListScreenTopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth().height(56.dp).background(Blue700),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.notes),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            fontSize = 25.sp
        )
    }
}
