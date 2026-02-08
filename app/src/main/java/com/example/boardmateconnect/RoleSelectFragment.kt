package com.example.boardmateconnect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.boardmateconnect.databinding.FragmentRoleSelectBinding

class RoleSelectFragment : Fragment() {

    // 1. Setup View Binding
    private var _binding: FragmentRoleSelectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using Binding
        _binding = FragmentRoleSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- OWNER BUTTON CLICK ---
        binding.btnOwner.setOnClickListener {
            // TODO: In the future, you might want to save "Role = Owner" to Firebase here.

            // Navigate to Create Connect Fragment
            // Make sure this action ID exists in your nav_graph.xml!
            findNavController().navigate(R.id.action_roleSelectFragment_to_createConnectFragment)
        }

        // --- TENANT BUTTON CLICK (Placeholder) ---
        binding.btnTenant.setOnClickListener {
            // Navigate to Code Fragment (where they enter the code)
            // findNavController().navigate(R.id.action_roleSelectFragment_to_codeFragment)
            findNavController().navigate(R.id.action_roleSelectFragment_to_codeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks
    }
}