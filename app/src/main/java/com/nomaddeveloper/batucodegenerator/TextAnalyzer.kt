package com.nomaddeveloper.batucodegenerator

import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class TextAnalyzer(private val onTextDetected: (MutableList<Text.TextBlock>) -> Unit) :
    ImageAnalysis.Analyzer {

    @OptIn(ExperimentalGetImage::class)
    override fun analyze(image: ImageProxy) {
        val mediaImage = image.image
        if (mediaImage != null) {
            val inputImage = InputImage.fromMediaImage(mediaImage, image.imageInfo.rotationDegrees)
            val detector = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
            detector.process(inputImage)
                .addOnSuccessListener {
                    val text = it.textBlocks
                    onTextDetected(text)
                }
                .addOnFailureListener {

                }
                .addOnCompleteListener {
                    mediaImage.close()
                }

        }
    }
}
