package p1admin.adminDB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import p1admin.model.Opcion;
import p1admin.model.Pregunta;

public class FauxDBFacade implements GenericDBFacade<Pregunta, Opcion>{

	static class OptionKey {
		private int option;
		private int idQuestion;

		public OptionKey(int option, int idQuestion) {
			this.option = option;
			this.idQuestion = idQuestion;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idQuestion;
			result = prime * result + option;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OptionKey other = (OptionKey) obj;
			if (idQuestion != other.idQuestion)
				return false;
			if (option != other.option)
				return false;
			return true;
		}
		
	}
	
	public Map<Integer, Pregunta> questions;
	public Map<OptionKey, Opcion> options;
	
	public FauxDBFacade() {
		this.questions = new HashMap<>();
		this.options = new HashMap<>();
	}
	
	@Override
	public void insertQuestion(Pregunta question) {
		int newId = questions.keySet().stream().max((x,y) -> x - y).orElse(1);
		question.setId(newId);
		System.out.println("Insertar pregunta en BD: " + question);
		questions.put(newId, question);
	}

	@Override
	public List<Pregunta> getAllQuestions() {
		System.out.println("Obtener todas las preguntas de la BD");
		return questions.values().stream().collect(Collectors.toList());
	}

	@Override
	public List<Pregunta> findQuestionsContaining(String text) {
		System.out.println("Búsqueda de preguntas que contienen: " + text);
		return questions.values()
				.stream()
				.filter(p -> p.getEnunciado().contains(text))
				.collect(Collectors.toList());
	}

	@Override
	public void updateQuestion(Pregunta question) {
		System.out.println("Actualizar pregunta: " + question);
		// Reintroducimos la pregunta en el Map, por si el objeto
		// question que nos pasan no es el mismo que el que ya
		// se encuentra en la BD.
		questions.put(question.getId(), question);
	}

	@Override
	public void updateAnswer(Pregunta question, Opcion answer) {
		System.out.println("Actualizar opción " + answer);
		// Reintroducimos la pregunta en el Map, por si el objeto
		// question que nos pasan no es el mismo que el que ya
		// se encuentra en la BD.
		options.put(new OptionKey(answer.getNumeroOrden(), question.getId()), answer);
	}

	@Override
	public void deleteAnswer(Pregunta question, Opcion answer) {
		System.out.println("Eliminar opción " + answer);
		options.remove(new OptionKey(answer.getNumeroOrden(), question.getId()));		
	}

	@Override
	public void deleteQuestion(Pregunta question) {
		System.out.println("Eliminar pregunta " + question);
		questions.remove(question.getId());
	}

	@Override
	public void insertAnswer(Pregunta question, Opcion answer) {
		System.out.println("Insertar respuesta " + answer);
		options.put(new OptionKey(answer.getNumeroOrden(), question.getId()), answer);
		
	}
	

}
