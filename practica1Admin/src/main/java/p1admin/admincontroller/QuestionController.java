package p1admin.admincontroller;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import p1admin.adminDB.GenericDBFacade;
import p1admin.model.Opcion;
import p1admin.model.Pregunta;

/**
 * Controlador de la ventana de edición de pregunta.
 *
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class QuestionController {
    private final GenericDBFacade<Pregunta, Opcion> dao;
    private final Pregunta model;
    private final DefaultListModel<Opcion> answersModel;

    public QuestionController(GenericDBFacade<Pregunta, Opcion> dao, Pregunta model, DefaultListModel<Opcion> answersModel) {
        this.dao = dao;
        this.model = model;
        this.answersModel = answersModel;
    }
    
    public String getQuestionStatement() {
    	return model.getEnunciado();
    }
    
    public String setQuestionStatement() {
        String newStatement = JOptionPane.showInputDialog("Introduce el nuevo enunciado:", model.getEnunciado());
        if (newStatement != null && !newStatement.trim().isEmpty()) {
        	model.setEnunciado(newStatement);
            dao.updateQuestion(model);
        }
        return newStatement;
    }
    
    public void addAnswer() {
        String answerText = JOptionPane.showInputDialog("Introduce nueva respuesta:");
        if (answerText != null && !answerText.trim().isEmpty()) {
            Opcion newAnswer = new Opcion();
            newAnswer.setTexto(answerText);
            model.addOpcion(newAnswer);
            answersModel.addElement(newAnswer);
            dao.insertAnswer(model, newAnswer);
        }
    }
    
    public void editAnswer(Opcion a) {
        String answerNewText = JOptionPane.showInputDialog("Introduce nuevo nombre de respuesta:", a.getTexto());
        if (answerNewText != null && !answerNewText.trim().isEmpty()) {
        	a.setTexto(answerNewText);
            dao.updateAnswer(model, a);
        }
    }

    public void removeAnswer(Opcion answer) {
    	model.removeOpcion(answer);
        int number = answer.getNumeroOrden();
        int numAnswers = model.getNumOpciones();
        answersModel.removeElement(answer);
        dao.deleteAnswer(model, answer);
        for (int i = number; i <= numAnswers; i++) {
        	Opcion currentAnswer = model.getOpcion(i);
            dao.updateAnswer(model, currentAnswer);
        }
    }

    public void moveAnswerUp(Opcion answer) {
    	int number = answer.getNumeroOrden();
        if (number > 1) {
        	Opcion previousAnswer = model.getOpcion(number - 1);
        	model.intercambiarOpciones(number, number - 1);
            answersModel.set(number - 1, previousAnswer);
            answersModel.set(number - 2, answer);
            dao.updateAnswer(model, answer);
            dao.updateAnswer(model, previousAnswer);
        }
    }

    public void moveAnswerDown(Opcion answer) {
    	int number = answer.getNumeroOrden();
    	int numAnswers = model.getNumOpciones();
        if (number < numAnswers) {
        	Opcion nextAnswer = model.getOpcion(number + 1);
        	model.intercambiarOpciones(number, number + 1);
            answersModel.set(number - 1, nextAnswer);
            answersModel.set(number, answer);
            dao.updateAnswer(model, answer);
            dao.updateAnswer(model, nextAnswer);
        }
    }
}
