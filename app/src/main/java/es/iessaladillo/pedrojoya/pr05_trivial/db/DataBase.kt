package es.iessaladillo.pedrojoya.pr05_trivial.db

private val questions:List<Question> =
    listOf(
        Question("¿Cual es el nombre completo de Baldomero Espartero?",
            listOf<Answer>(Answer("Joaquín Baldomero Fernández-Espartero Álvarez de Toro",true),Answer("Baldomero Llegate Ligero",false),
                Answer("Daniel",false),Answer("Jose Baldomero Espartero",false))),
        Question("Pregunta2",
            listOf<Answer>(Answer("a",false),Answer("b",false),
                Answer("c",false),Answer("d1",true))),
        Question("Pregunta3",
            listOf<Answer>(Answer("",false),Answer("d",true),
                Answer("",false),Answer("",false))),
        Question("Pregunta4",
            listOf<Answer>(Answer("",false),Answer("",false),
                Answer("d",true),Answer("",false))),
        Question("Pregunta5",
            listOf<Answer>(Answer("d",true),Answer("",false),
                Answer("",false),Answer("",false))),
        Question("Pregunta6",
            listOf<Answer>(Answer("",false),Answer("f",true),
                Answer("",false),Answer("",false))),
        Question("Pregunta7",
            listOf<Answer>(Answer("f",true),Answer("",false),
                Answer("",false),Answer("",false))),
        Question("Pregunta8",
            listOf<Answer>(Answer("",false),Answer("",false),
                Answer("",false),Answer("f",true))),
        Question("Pregunta9",
            listOf<Answer>(Answer("",false),Answer("",false),
                Answer("",false),Answer("d",true))),
        Question("Pregunta10",
            listOf<Answer>(Answer("d",true),Answer("",false),
                Answer("",false),Answer("",false))),
        Question("Pregunta11",
            listOf<Answer>(Answer("",false),Answer("",false),
                Answer("d",true),Answer("",false))))


public fun getQuestions():List<Question>{
    return questions.shuffled()
}