package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class MainFragment: Fragment(){
    private val viewModel:MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val editText = view.findViewById<EditText>(R.id.editText)
        var progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        var textView = view.findViewById<TextView>(R.id.textView)
        var imageView = view.findViewById<ImageView>(R.id.imageView)
        progressBar.visibility = View.VISIBLE
        Picasso.get()
            .load("https://source.unsplash.com/random")
            .error(R.drawable.ic_launcher_background)
            .into(imageView, object: com.squareup.picasso.Callback{
            override fun onError(e: Exception?) {
                editText.error
            }
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
        })
        /*editText.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrEmpty())
                viewModel.loadPosts(s.toString().toInt(), imageView, pa)
            }
        })*/
        /*viewModel.posts.observe(viewLifecycleOwner){
            when(it){
                is Resource.Loading ->{
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success ->{
                    progressBar.visibility = View.GONE
                    Picasso.get().load("https://source.unsplash.com/random").into(imageView)
                    //viewModel.loadPosts(imageView, container!!, this.requireContext())
                    //textView.text = it.data.toString()
                }
                is Resource.Error ->{
                    progressBar.visibility = View.GONE
                    editText.error = it.message
                }
            }
        }*/
        return view
    }
}