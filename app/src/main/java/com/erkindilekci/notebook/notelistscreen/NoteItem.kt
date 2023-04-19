package com.erkindilekci.notebook.notelistscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erkindilekci.notebook.room.Note

@Composable
fun NoteItem(
    note: Note,
    onDeleteClick: () -> Unit,
    onItemClick: () -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp, start = 10.dp, end = 10.dp)) {
        Column(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .fillMaxSize().heightIn(min = 75.dp)
                .clickable { onItemClick() },
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = note.title, fontWeight = FontWeight.SemiBold, fontSize = 20.sp)

                IconButton(onClick = { onDeleteClick() }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                }
            }

            Row(modifier = Modifier
                .fillMaxWidth()
            ) {
                Text(text = note.description, fontSize = 18.sp, modifier = Modifier.padding(bottom = 5.dp))
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun ItemReview() {

}
