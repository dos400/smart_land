package uz.hamroev.smartland.fragment

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.smartland.R
import uz.hamroev.smartland.adapter.SectionAdapter
import uz.hamroev.smartland.cache.Cache
import uz.hamroev.smartland.databinding.DialogLanguageBinding
import uz.hamroev.smartland.databinding.FragmentHomeBinding
import uz.hamroev.smartland.model.Section
import uz.hamroev.smartland.onDataPass.OnDataPass
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var list: ArrayList<Section>
    lateinit var sectionAdapter: SectionAdapter
    private val TAG = "HomeFragment"
    lateinit var dataPass: OnDataPass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        Log.d(TAG, "onCreateView: OnCreate")
        checkLanguage()

        binding.cardLanguage.setOnClickListener {
            val alertDialog = AlertDialog.Builder(binding.root.context)
            val dialog = alertDialog.create()
            val bindingLanguage =
                DialogLanguageBinding.inflate(LayoutInflater.from(activity?.applicationContext))
            dialog.setView(bindingLanguage.root)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(true)

            bindingLanguage.textRu.text = resources.getString(R.string.language_rus)
            bindingLanguage.textUk.text = resources.getString(R.string.language_eng)
            bindingLanguage.textUz.text = resources.getString(R.string.language_uzb)

            bindingLanguage.russian.setOnClickListener {
                Cache.language = "ru"
                findNavController().popBackStack()
                findNavController().navigate(R.id.homeFragment)
                dialog.dismiss()
            }
            bindingLanguage.uk.setOnClickListener {
                Cache.language = "en"
                findNavController().popBackStack()
                findNavController().navigate(R.id.homeFragment)
                dialog.dismiss()
            }
            bindingLanguage.uzb.setOnClickListener {
                Cache.language = "uz"
                findNavController().popBackStack()
                findNavController().navigate(R.id.homeFragment)
                dialog.dismiss()
            }

            dialog.show()

        }

        binding.cardWeather.setOnClickListener {
            findNavController().navigate(R.id.weatherFragment)
        }
        startTypeWriterTitle()

        loadSection()
        sectionAdapter = SectionAdapter(
            binding.root.context,
            list,
            object : SectionAdapter.OnSectionClickListener {
                override fun onClick(section: Section, position: Int) {
                    when (position) {
                        0 -> {
                            findNavController().navigate(R.id.avtomatikFragment)
                        }
                        1 -> {
                            findNavController().navigate(R.id.agrotexnikaFragment)
                        }
                        2 -> {
                            findNavController().navigate(R.id.daromadFragment)
                        }
                        3 -> {
                            findNavController().navigate(R.id.mualliflarFragment)
                        }
                    }
                }
            })
        binding.rvSection.adapter = sectionAdapter


        return binding.root
    }

    private fun startTypeWriterTitle() {
        binding.titleTypeWriter.animateText(resources.getString(R.string.title))
        binding.titleTypeWriter.setCharacterDeley(100)
    }

    private fun loadSection() {
        list = ArrayList()
        list.add(Section(resources.getString(R.string.theme1), R.drawable.ic_theme1))
        list.add(Section(resources.getString(R.string.theme2), R.drawable.ic_theme2))
        list.add(Section(resources.getString(R.string.theme3), R.drawable.ic_theme3))
        list.add(Section(resources.getString(R.string.mualliflar), R.drawable.ic_mualliflar))
    }

    private fun checkLanguage() {
        when (Cache.language) {
            "en" -> {
                setAppLocale(binding.root.context, "en")
            }
            "ru" -> {
                setAppLocale(binding.root.context, "ru")
            }
            "uz" -> {
                setAppLocale(binding.root.context, "uz")
            }
        }
    }

    fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(
            config,
            context.resources.displayMetrics
        )
    }

    fun passData(data: Int) {
        dataPass.onDataPass(data)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPass = context as OnDataPass
    }


}