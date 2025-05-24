package com.bbg.bbgconnect.presentation.ui.sozialMedia

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bbg.bbgconnect.data.models.SocialMedia
import com.bbg.bbgconnect.presentation.ui.theme.CustomIcons

/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun SocialLinks(social: SocialMedia) {
    val context = LocalContext.current

    Row(modifier = Modifier.padding(bottom = 16.dp)) {

        if (social.linkedin != null) {
            SocialIcon(CustomIcons.LinkedIn) { openUrl(context, social.linkedin!!) }
        }
        if (social.facebook != null) {
            SocialIcon(CustomIcons.Facebook) { openUrl(context, social.facebook!!) }
        }
        if (social.twitter != null) {
            SocialIcon(CustomIcons.Twitter) { openUrl(context, social.twitter!!) }
        }
        if (social.instagram != null) {
            SocialIcon(CustomIcons.Instagram) { openUrl(context, social.instagram!!) }
        }
    }
}

