package com.bbg.bbgconnect.presentation.ui.location

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bbg.bbgconnect.data.models.Location
import com.bbg.bbgconnect.presentation.ui.location.helper.toMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
/**
 * Created by Enoklit on 21.05.2025.
 */
@Composable
fun LocationMap(
    locations: List<Location>,
    selectedLocationId: String?,
    getLocalizedText: (Map<String, String>) -> String,
    onSelectLocation: (String) -> Unit
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(51.1657, 10.4515), 5f)
    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            locations.forEach { location ->
                Marker(
                    state = MarkerState(
                        position = LatLng(
                            location.coordinates.latitude,
                            location.coordinates.longitude
                        )
                    ),
                    title = getLocalizedText(location.name.toMap()),
                    snippet = "${location.city}, ${location.country}",
                    onClick = {
                        onSelectLocation(location.id)
                        false
                    }
                )
            }
        }
    }
}


