package com.Sutabah.JenisJenisHewan

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.Sutabah.JenisJenisHewan.adapter.AdapterJenisHewan
import com.Sutabah.JenisJenisHewan.databinding.ActivityMainBinding
import com.Sutabah.JenisJenisHewan.model.Hewan

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listhewan = ArrayList<Hewan>()
        listhewan.add(Hewan("Sapi", R.drawable.sapi, "Rumput", "Daratan", "Herbivora"))
        listhewan.add(Hewan("Kuda", R.drawable.kuda, "Rumput", "Daratan", "Herbivora"))
        listhewan.add(Hewan("Harimau", R.drawable.harimau, "Daging", "Daratan", "Karnivora"))
        listhewan.add(Hewan("Buaya", R.drawable.buaya, "Daging", "Daratan dan air", "Karnivora"))
        listhewan.add(Hewan("Singa", R.drawable.singa, "Daging", "Daratan", "Karnivora"))
        listhewan.add(Hewan("Rusa", R.drawable.rusa, "buah", "Daratan", "Herbivora"))
        listhewan.add(Hewan("ikan", R.drawable.ikan, "jentik", "Air", "Omnivora"))
        listhewan.add(Hewan("Kambing", R.drawable.kambing, "Rumput", "Daratan", "Herbivora"))
        listhewan.add(Hewan("Kucing", R.drawable.kucing, "Daging", "Daratan", "Karnivora"))
        listhewan.add(Hewan("Panda", R.drawable.panda, "Bambu", "Daratan", "Herbivora"))

        binding.list.adapter =
            AdapterJenisHewan(this, listhewan, object : AdapterJenisHewan.OnclickListener{
                override fun detailData(item: Hewan?) {
                    Dialog(this@MainActivity).apply {
                        requestWindowFeature(Window.FEATURE_NO_TITLE)
                        setCancelable(true)
                        setContentView(R.layout.detail_data_hewan)

                        val image = this.findViewById<ImageView>(R.id.image_hewan)
                        val nama = this.findViewById<TextView>(R.id.txtnamahewan)

                        val makanan = this.findViewById<TextView>(R.id.txtmakananhewan)
                        val tempattinggal = this.findViewById<TextView>(R.id.txttempattinggalhewan)
                        val golongan = this.findViewById<TextView>(R.id.txtgolonganhewan)
                        val btn = this.findViewById<TextView>(R.id.btnclose)

                        image.setImageResource(item?.foto ?:0)
                        nama.text = "${item?.nama}"
                        makanan.text = "${item?.makanan}"
                        tempattinggal.text = "${item?.tempattinggal}"
                        golongan.text = "${item?.Golongan}"

                        btn.setOnClickListener{
                            this.dismiss()
                        }
                    }.show()
                }


            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode : Int){
        when (selectedMode) {
            R.id.myprofile -> {
                val intent = Intent(this,Profile::class.java)
                startActivity(intent)
            }
        }
    }
}

