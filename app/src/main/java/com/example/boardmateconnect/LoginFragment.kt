package com.example.boardmateconnect
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.boardmateconnect.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    // 1. Setup View Binding (Better than findViewById)
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using Binding
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- GOOGLE LOGIN (Your Intent Code) ---
        binding.imageView.setOnClickListener {
            // Opens Google Accounts in the browser
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/"))
            startActivity(intent)
        }

        // --- LOGIN BUTTON ---
        binding.loginButton.setOnClickListener {
            val email = binding.etUserEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                // TODO: Add logic here to move to the Home Screen
                val bundle = Bundle()
                bundle.putString("userEmail", email)
                findNavController().navigate(R.id.action_loginFragment_to_roleSelectFragment, bundle)
            } else {
                Toast.makeText(context, "Please enter Email and Password", Toast.LENGTH_SHORT).show()
            }
        }

        // --- SIGN UP BUTTON ---
        binding.signUpButton.setOnClickListener {
            Toast.makeText(context, "Going to Sign Up...", Toast.LENGTH_SHORT).show()

            // TODO: Navigate to Sign Up Fragment
            // 1. Create a SignUpFragment
            // 2. Add action in nav_graph.xml
            // 3. Uncomment below:
            // findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }

        // --- FORGOT PASSWORD ---
        binding.forgotPassword.setOnClickListener {
            Toast.makeText(context, "Going to Forgot Password...", Toast.LENGTH_SHORT).show()

            // TODO: Navigate to your Splash Screen
            // 1. Create your new SplashFragment
            // 2. Add action in nav_graph.xml
            // 3. Uncomment below:
            // findNavController().navigate(R.id.action_loginFragment_to_splashFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Prevent memory leaks
        _binding = null
    }
}