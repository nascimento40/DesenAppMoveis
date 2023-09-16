package com.example.provapratica1

class ListaCompromissos private constructor() {

    companion object {

        private var listaCompromissos = mutableListOf<Compromisso>()

         fun addCompromisso (compromisso: Compromisso) {
             listaCompromissos.add(compromisso)
         }

        fun removeComnpromisso (position: Int){
            listaCompromissos.removeAt(position)
        }

        fun getCompromisso(position: Int) : Compromisso {
            return listaCompromissos[position]
        }

        fun getListSize(): Int {
            return listaCompromissos.size
        }

    }
}