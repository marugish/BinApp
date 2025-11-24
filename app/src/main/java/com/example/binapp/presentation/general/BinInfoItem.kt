package com.example.binapp.presentation.general

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.binapp.R
import com.example.binapp.domain.model.Bin

@Composable
fun BinInfoItem(
    binInfo: Bin,
    onLinkClick: () -> Unit,
    onCoordinateClick: () -> Unit,
    onPhoneClick: () -> Unit
) {
    val titleTextStyle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 14.sp,
        fontFamily = FontFamily.Serif,
        color = colorResource(R.color.purple),
    )
    val ordinaryTextStyle = TextStyle(
        fontSize = 12.sp,
        lineHeight = 12.sp,
        fontFamily = FontFamily.Serif,
        color = colorResource(R.color.black),
    )
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE9E8E8),
                        Color(0xFFE9E8E8),
                        Color(0xBD9D9C9C)
                    )
                ),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Text(
            text = "BIN/IIN : ${binInfo.name}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Serif,
            color = colorResource(R.color.purple),
            modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
            textAlign = TextAlign.Center
        )
        Row(modifier = Modifier.padding(
            top = 8.dp,
            start = 16.dp,
            end = 16.dp,
            bottom = 16.dp
        )
        ) {
            Column(
                modifier = Modifier.weight(0.4f)
            ) {
                // SCHEME
                Text(
                    text = "SCHEME",
                    style = titleTextStyle,
                )
                Text(
                    text = binInfo.scheme,
                    style = ordinaryTextStyle,
                    modifier = Modifier.padding(top = 4.dp),
                )
                // BRAND
                Text(
                    text = "BRAND",
                    style = titleTextStyle,
                    modifier = Modifier.padding(top = 8.dp),
                )
                Text(
                    text = binInfo.brand,
                    style = ordinaryTextStyle,
                    modifier = Modifier.padding(top = 4.dp),
                )
                // TYPE
                Text(
                    text = "TYPE",
                    style = titleTextStyle,
                    modifier = Modifier.padding(top = 8.dp),
                )
                Text(
                    text = binInfo.type,
                    style = ordinaryTextStyle,
                    modifier = Modifier.padding(top = 4.dp),
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(0.6f)
            ) {
                // COUNTRY
                Text(
                    text = "COUNTRY",
                    style = titleTextStyle,
                )
                Text(
                    text = "${binInfo.country.emoji} ${binInfo.country.name}",
                    style = ordinaryTextStyle,
                    modifier = Modifier.padding(top = 4.dp),
                )
                Text(
                    text = "Coordinates: ${binInfo.country.latitude}, ${binInfo.country.longitude}",
                    style = ordinaryTextStyle,
                    color = colorResource(R.color.blue),
                    modifier = Modifier.padding(top = 4.dp)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                onCoordinateClick()
                            }
                        },
                    textDecoration = TextDecoration.combine(listOf(TextDecoration.Underline)),
                )
                // BANK
                Text(
                    text = "BANK",
                    style = titleTextStyle,
                    modifier = Modifier.padding(top = 8.dp),
                )
                Text(
                    text = "${binInfo.bank.name}, ${binInfo.bank.city}",
                    style = ordinaryTextStyle,
                    modifier = Modifier.padding(top = 4.dp),
                )
                if (binInfo.bank.url.isNotEmpty()) {
                    Text(
                        text = binInfo.bank.url,
                        style = ordinaryTextStyle,
                        color = colorResource(R.color.blue),
                        modifier = Modifier.padding(top = 4.dp)
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    onLinkClick()
                                }
                            },
                        textDecoration = TextDecoration.combine(listOf(TextDecoration.Underline)),
                    )
                }
                if (binInfo.bank.phone.isNotEmpty()) {
                    Text(
                        text = binInfo.bank.phone,
                        style = ordinaryTextStyle,
                        color = colorResource(R.color.blue),
                        modifier = Modifier.padding(top = 4.dp)
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    onPhoneClick()
                                }
                            }
                    )
                }
            }
        }
    }
}