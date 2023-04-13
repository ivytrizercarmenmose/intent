package com.example.intent_carmen

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnsms:Button
    private lateinit var btnemail:Button
    private lateinit var btncamera:Button
    private lateinit var btnshare:Button
    private lateinit var btnmpesa:Button
    private lateinit var btncall:Button
    private lateinit var btnwebsite:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsms = findViewById(R.id.btnsms)
        btnemail = findViewById(R.id.btnemail)
        btncamera = findViewById(R.id.btncamera)
        btnshare = findViewById(R.id.btnshare)
        btnmpesa = findViewById(R.id.btnmpesa)
        btncall = findViewById(R.id.btncall)
        btnwebsite = findViewById(R.id.btnwebsite)


        btnwebsite.setOnClickListener {
            //code to navigate to another activity
            val gotowebsite = Intent(this,websieActivity::class.java)
            startActivity(gotowebsite)
        }



        btnsms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0716294504")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "hey,long time")
            startActivity(intent)}
        btnemail.setOnClickListener {


            var emailIntent = Intent(
                Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", "carmenmose2004@gmail.com", "nul")
            )
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Job Application")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear sir,i'm applyng for the job posted")
            startActivity(Intent.createChooser(emailIntent, "Send Email"))}



            btncamera.setOnClickListener {
                val takePictureintent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(takePictureintent, 1)}



                btnmpesa.setOnClickListener {
                    val simToolKitintent =
                        applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                    simToolKitintent?.let { startActivity(it) }


                }

                btncall.setOnClickListener {
                    val intent = Intent(Intent.ACTION_CALL, Uri.parse("call:+254716294504"))
                    if (ContextCompat.checkSelfPermission(
                            this@MainActivity,
                            android.Manifest.permission.CALL_PHONE
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(
                            this@MainActivity,
                            arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                            1
                        )
                    } else {
                        startActivity(intent)
                    }
                }
            }
        }
