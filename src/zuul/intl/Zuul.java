package zuul.intl;

import java.util.ListResourceBundle;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class Zuul extends ListResourceBundle {
    static final Object[][] contents = {    	
    	
            {"lunchroom.description", "Vous êtes dans la cafétéria. Pourquoi ne pas vous prendre un café Mocoffee?\n Mocoffee est un excellent café du Nicaragua, sans édulcorant de synthèse.\n Cela vous donnera un peu d'energie.\n Tapez \"take coffee\" pour prendre un café"},
            {"lectureroom.description1", "Vous êtes dans une salle de classe.\nVous pouvez assister au cours de "},
            {"lectureroom.description2", "pour cela, tapez \"attend lecture\" \n" },
            {"labroom.description1", "Vous êtes dans la salle de TP.\nVous pouvez assister au cours de "},
            {"labroom.description2", "pour cela, tapez \"attend lab\" \n" },
            {"corridor1.description", "Vous êtes dans le premier couloir"},
            {"corridor2.description", "Vous êtes dans le deuxième couloir"},
            {"corridor3.description", "Vous êtes dans le troisième couloir"},
            {"corridor4.description", "Vous êtes dans le quatrième couloir"},
            {"corridor.tablet", "Vous trouvez une tablette dans le couloir. Pour l'utiliser, tapez \"use tablet\""},
            {"corridor.notablet", "Quelle tablette ?"},
            {"corridor.cheatsheet", "Un bout de papier dépasse de l'imprimante...Pour aller voir, tapez \"search printer\""},
            {"corridor.nocheatsheet", "Quelle imprimante ?"},
            {"library.description", "Vous êtes dans la bibliothèque. Dans la bibliothèque, vous trouvez le livre de POO2 renfermant l'ensemble des cours de la matière.\n Pour lire le livre et acquérir l'ensemble des cours, tapez \"read book\""},
            {"examroom.description", "Vous êtes dans la salle d'examen"},
            {"corridor.dark","Ce couloir est d'une obscurité déconcertante, vous pourriez allumer la lumiere pour mieux y voir...\n Pour allumer la lumiere, tapez \"light on\""},
            {"library.closed","La porte est fermée à clé. Il est vrai que la bibliothèque est fermée 7 fois sur 10. Revenez plus tard !"},
            {"lunchroom.coffee1","C'est pas le meilleur café de ma vie mais je me sens mieux !"},
            {"lunchroom.coffee2", "Merci Mocoffee !"},

            {"oop.lecture", "Il faut savoir...blabla"},
            {"oop.lecture1", "...les développeurs souhaitent une cohésion élevée et un couplage faible..."},
            {"oop.lecture2", "...les interfaces n'ont pas besoin de constructeur..."},
            {"oop.lecture3", "...une sous-classe doit obligatoirement faire appel à 'super' dans son constructeur..."},
            {"oop.lectureend", "Voilà, c'est tout pour aujourd'hui. Apprenez bien votre cours pour la prochaine fois."},

            {"c.lecture1", "... la programmation C n'est pas une programmation orienté objet..."},
            {"c.lecture2", "...on declare un tableau avec des [] exemple int tab[]..."},
            {"c.lecture3", "...un pointeur se declare comme suit : int *p..."},
            
            {"algo.lecture1", "...on utilise le pivot de gauss pour obtenir une matrice triangulaire supérieure..."},
            {"algo.lecture2", "...Utiliser les differences divisées est la méthode la plus simple pour obtenir le polynôme le plus proche d'une fonction..."},
            {"algo.lecture3", "...si le déterminant d'une matrice est différent de 0 la matrice est inversible..."},
            
            
            {"oop.exam.description", "Vous allez passer un examen, veuillez répondre par VRAI ou FAUX."},
            {"oop.exam.question1", "Un constructeur est-il nécessaire dans une interface ?"},
            {"oop.exam.question2", "Est-il vrai que les développeurs veulent une cohésion faible et un couplage élevé ?"},
            {"oop.exam.question3", "Un constructeur d'une sous-classe doit-il contenir obligatoirement un appel de 'super' ?"},
            {"oop.exam.answer1", "FAUX"},
            {"oop.exam.answer2", "FAUX"},
            {"oop.exam.answer3", "VRAI"},
            {"oop.exam.rightanswer", "La réponse est : "},

            {"game.welcome", "Bienvenue dans Le Monde de Zuul!"},
            {"game.boring", "Le Monde de Zuul est un nouveau jeu d'aventure incroyablement (un peu moins) chiant."},
            {"game.help", "Tapez 'help' si vous avez besoin d'aide."},
            {"game.idontknow", "Je ne comprends pas..."},
            {"game.use","Utiliser quoi ? une tablette peut être ?"},
            {"game.attend","Assister à quoi ? lab ? cours ?"},
            {"game.help2", "Vous êtes un étudiant et vous devez passer l'examen final de POO."},
            {"game.help3", "Pour cela, vous devez suivre des cours, des TP et réussir l'examen."},
            {"game.help4", "Les commandes sont:"},
            {"game.where", "Aller où?"},
            {"game.take", "Prendre quoi ? un café peut être ? Tapez: take coffee"},
            {"game.nodoor", "Il n'y a pas de porte !"},
            {"game.quitwhat", "Quitter quoi?"},
            {"game.exits", "Sorties:"},
            {"game.thankyou", "Merci d'avoir joué. Au revoir."},
            {"game.askname", "Quel est votre nom ?"},
            {"game.welcomename1", "Bienvenue "},
            {"game.welcomename2", " ! Mais je trouve que ce prénom ne vous va pas très bien...je vais vous appeler "},
            {"game.welcomename3", " la brutasse !"},
			{"game.read","Lire quoi ? "},
            {"game.win", "Félicitations ! Vous avez réussi à passer l'examen final de POO et vous avez donc terminé le jeu."},
            {"game.lose", "Désolé, vous n'avez pas la moyenne à l'examen final et vous devez le repasser..."},

            {"student.youhave", "Vous avez "},
            {"student.answers", " réponses justes."},
            {"student.energy.part1", "L'énergie de "},
            {"student.energy.part2", " est de "},
            {"student.energy0", "Vous n'avez plus d'énergie ! Vous vous endormez sur place...Jojo la menace vous voit et décide de vous renvoyer...Faites attention la prochaine fois."},
            {"student.addLab.part1"," a suivi avec succès le lab de "},
            {"student.add.part2"," numéro "},
            {"student.addLecture.part1"," a suivi avec succès le cours de "},
            {"student.removeLecture1","Vous avez oublié le cours de "},
            {"student.removeLecture2"," numero "},
            {"student.removeLab1","Vous avez oublié le lab de "},
            {"student.removeLab2"," numéro "},
            
            {"lectureroom.attendlecture.part1","le cours de "},
            {"lectureroom.attendlecture.part4","Merci d'avoir écouté ce cours vous pouvez donc assister au lab !"},
            {"room.attend.part2"," numéro "},
            {"room.attend.part3"," va commencer !"},
            {"labroom.attendlab.part1","le lab de "},
            {"labroom.attendlab.part4","Merci d'avoir participé à ce lab !"},
            {"labroom.noattend1","Le professeur ne veut pas de vous car vous n'avez pas assisté au cours concernant le module de "},
            {"labroom.noattend2"," numéro "},
            {"lunchroom.babyFoot","Tu es dans la cafétéria. Salah et Fanfan la tulipe t'attrapent au passage : C'est l'heure du baby ! Vous ne pouvez refuser."},
            {"examroom.cant", "Vous ne pouvez pas passer l'examen dans ces conditions..."},

            {"tablet.lecture","Vous constatez que l'étudiant qui a laissé la tablette a enregistré un cours dessus. Pourquoi ne pas l'apprendre ?"},
            {"tablet.zuul","Oh oui! Vous avez vu le monde de Zuul sur la tablette. Vous lancez dans une partie."},
            {"tablet.appli","Oh non! Vous avez vu \"Candy Crush - Oubliez vos cours et jouez avec moi\" sur la tablette. Vous vous lancez dans une partie..."},
        	{"tablet.on","$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$_$$$$$$$$$$$$$$$$_$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$__$$$$$$$$$$$$$$_$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$$_______________$$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$___________________$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$____$$$_________$$$____$$$$$$$$$$$$$\n$$$$$$$$$$$$$_____$$$_________$$$_____$$$$$$$$$$$$\n$$$$$$$$$$$$___________________________$$$$$$$$$$$\n$$$$$$$$$$$$___________________________$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n$$$$_____$$$____________________________$$$____$$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$______$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$$___$$$$____________________________$$$___$$$$\n$$$$$$$$$$$$____________________________$$$$$$$$$$\n$$$$$$$$$$$$____________________________$$$$$$$$$$\n$$$$$$$$$$$$___________________________$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n La tablette Android est allumée!"},

            {"cheatsheet.description1", "Vous venez de trouver une feuille avec quelque chose d'écrit dessus..."},
            {"cheatsheet.description2", "Réponses à l'examen de POO : "}
            
    };


    @Override
    public Object[][] getContents() {
        return contents;
    }
}
