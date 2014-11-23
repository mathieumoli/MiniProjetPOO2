package zuul.intl;

import java.util.ListResourceBundle;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class Zuul extends ListResourceBundle {
    static final Object[][] contents = {
            {"hall.description", "Vous êtes dans le hall"},
            {"lunchroom.description", "Vous êtes dans la cafétéria. Pourquoi ne pas vous prendre un café Mocoffee?\n Mocoffee est un excellent café du Nicaragua, sans édulcorant de synthèse.\n Cela vous donnera un peu d'energie.\n Tapez \"take coffee\" pour prendre un café"},
            {"lectureroom.description", "Vous êtes dans la salle de classe"},
            {"labroom.description", "Vous êtes dans la salle de TP"},
            {"corridor1.description", "Vous êtes dans le premier couloir"},
            {"corridor2.description", "Vous êtes dans le deuxième couloir"},
            {"library.description", "Vous êtes dans la bibliothèque"},
            {"examroom.description", "Vous êtes dans la salle d'examen"},
            {"corridor.dark","Ce couloir est d'une obscurité déconcertante, vous pourriez allumer la lumiere pour mieux y voir...\n Pour allumer la lumiere, tapez \"light on\""},
            {"library.closed","La porte est fermée à clé. Il est vrai que la bibliotheque est fermée 7/10. Revenez plus tard !"},
            {"lunchroom.coffee1","C'est pas le meilleur café de ma vie mais je me sens mieux !"},
            {"lunchroom.coffee2", "Merci Mocoffee !"},
            
            {"game.welcome", "Bienvenue dans Le Monde de Zuul!"},
            {"game.boring", "Le Monde de Zuul est un nouveau jeu d'aventure incroyablement (un peu moins) chiant."},
            {"game.help", "Tapez 'help' si vous avez besoin d'aide."},
            {"game.idontknow", "Je ne comprends pas..."},
            {"game.help2", "Vous êtes un étudiant et vous devez passer l'examen final de POO."},
            {"game.help3", "Pour cela, vous devez suivre des cours, des TP et réussir l'examen."},
            {"game.help4", "Les commandes sont:"},
            {"game.where", "Aller où?"},
            {"game.take", "Prendre quoi ? un café peut être ? Tapez: take coffee"},
            {"game.nodoor", "Il n'y a pas de porte !"},
            {"game.quitwhat", "Quitter quoi?"},
            {"game.exits", "Sorties:"},
            {"game.thankyou", "Merci d'avoir joué. Au revoir."},
            
            {"student.energy.part1", "L'énergie de "},
            {"student.energy.part2", " est de "},
            {"student.addLab.part1"," a suivi avec succès le lab de "},
            {"student.add.part2"," numero "},
            {"student.addLecture.part1"," a suivi avec succès le cours de "},
            
            {"lectureroom.attendlecture.part1","le cours de "},
            {"room.attend.part2"," numero "},
            {"room.attend.part3"," va commencer !"},
            {"lectureroom.attendlecture.part4","Merci d'avoir écouté ce cours vous pouvez donc assister au lab !"}


    };


    @Override
    public Object[][] getContents() {
        return contents;
    }
}
