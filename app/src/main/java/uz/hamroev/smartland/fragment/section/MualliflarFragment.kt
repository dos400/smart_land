package uz.hamroev.smartland.fragment.section

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.hamroev.smartland.R
import uz.hamroev.smartland.adapter.AuthorAdapter
import uz.hamroev.smartland.cache.Cache
import uz.hamroev.smartland.databinding.FragmentMualliflarBinding
import uz.hamroev.smartland.model.Author


class MualliflarFragment : Fragment() {


    lateinit var binding: FragmentMualliflarBinding
    lateinit var authorAdapter: AuthorAdapter
    lateinit var listAuthor: ArrayList<Author>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMualliflarBinding.inflate(layoutInflater, container, false)

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        loadAuthors()
        authorAdapter = AuthorAdapter(binding.root.context, listAuthor)
        binding.rvAuthor.adapter = authorAdapter



        return binding.root
    }

    private fun loadAuthors() {
        listAuthor = ArrayList()
        when (Cache.language) {
            "en" -> {
                listAuthor.add(Author("", "", R.drawable.user1))
                listAuthor.add(Author("", "", R.drawable.user2))
                listAuthor.add(Author("", "", R.drawable.user3))
            }
            "ru" -> {
                listAuthor.add(Author("", "", R.drawable.user1))
                listAuthor.add(Author("", "", R.drawable.user2))
                listAuthor.add(Author("", "", R.drawable.user3))
            }
            "uz" -> {
                listAuthor.add(Author("", "", R.drawable.user1))
                listAuthor.add(Author("", "", R.drawable.user2))
                listAuthor.add(Author("", "", R.drawable.user3))
            }
        }

    }

}
