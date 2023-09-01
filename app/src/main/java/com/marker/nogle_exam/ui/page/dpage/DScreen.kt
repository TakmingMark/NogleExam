package com.marker.nogle_exam.ui.page.dpage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marker.nogle_exam.R


@Composable
fun DScreen(onSwitchToSettingScreenListener: () -> Unit) {

    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier
                    .padding(24.dp)
                    .size(32.dp)
                    .clickable {
                        onSwitchToSettingScreenListener.invoke()
                    },
                painter = painterResource(id = R.drawable.baseline_settings_24),
                contentDescription = null
            )
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Test DScreen", fontSize = 24.sp)
        }
    }
}