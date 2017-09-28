package task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Battle {
	
	private static String OPTIMUS_PRIME = "Optimus Prime";

	private static String PREDAKING = "Predaking";
	


	public static void main(String[] args) {
		List<Transformer> transformers = new ArrayList<Transformer>();
		transformers.add(new Autobot("Hubcap", 4,4,4,4,4,4,4,4));
		transformers.add(new Deception("Soundwave",8,9,2,6,7,5,6,10));
		transformers.add(new Autobot("Bluestreak",6,6,7,9,5,2,9,7));
		
		fighting(transformers);
	}

	public static void fighting(List<Transformer> transformers) {
		List<Result> result = new ArrayList<Result>();
		List<Transformer> autobots = transformers.stream().filter(t -> t instanceof Autobot).sorted((a1, a2) -> Integer.compare(a1.total(), a2.total())).collect(Collectors.toList());
		List<Transformer> deceptions = transformers.stream().filter(t -> t instanceof Deception).sorted((d1, d2) -> Integer.compare(d1.total(), d2.total())).collect(Collectors.toList());
		int countDeception = (int) deceptions.stream().count();
		int countAutobot = (int) autobots.stream().count();
		int battleCount = 0;
		if (countAutobot > countDeception) {
			findSurviver(autobots, result, countAutobot);
		} else if (countAutobot < countDeception) {
			findSurviver(deceptions, result, countDeception);
		}

		battleCount = (int) ((autobots.stream().count() + deceptions.stream().count()) / 2);

		for (int i = 0; i < battleCount; i++) {
			Autobot autobot = (Autobot) autobots.get(i);
			Deception deception = (Deception) deceptions.get(i);
			if (!skipBattleSuperPower(autobot, deception, result)) {
				findWin(autobot, deception, result);
			}
		}
		print(result, battleCount);
	}

	private static void findSurviver(List<Transformer> transformers, List<Result> result, Integer count) {
		for (int i = 1; i < count; i++) {
			Transformer transformer = transformers.get(0);
			result.add(new Result(Status.SURVIVOR, transformer));
			transformers.remove(transformer);
		}

	}


	private static boolean skipBattleSuperPower(Transformer t, Transformer t2, List<Result> result) {
		if (t.getCourage() > t2.getCourage() && t.getCourage() + 4 > t2.getCourage() || t.getStrength() > t2.getStrength() && t.getStrength() + 3 > t2.getStrength()) {
			result.add(new Result(Status.WINNER, t));
			result.add(new Result(Status.DEAD, t2));
			return true;
		} else if (t2.getCourage() > t.getCourage() && t2.getCourage() + 4 > t.getCourage() || t2.getStrength() > t.getStrength() && t2.getStrength() + 3 > t.getStrength()) {
			result.add(new Result(Status.WINNER, t2));
			result.add(new Result(Status.DEAD, t));
			return true;
		}
		return false;
		
	}

	private static void findWin(Autobot a, Deception d,  List<Result> result) {
		if (verifyTransformerSuperPower(a) || a.total() > d.total()) {
			result.add(new Result(Status.WINNER, a));
			result.add(new Result(Status.DEAD, d));
		} else if (verifyTransformerSuperPower(d)|| a.total() < d.total()) {
			result.add(new Result(Status.WINNER, d));
			result.add(new Result(Status.DEAD, a));
		}
		
	}
	
	private static boolean verifyTransformerSuperPower(Transformer t){
		return t.getName().equals(OPTIMUS_PRIME) || t.getName().equals(PREDAKING);
	}
	
	private static void print(List<Result> result, Integer countBattle) {
		System.out.println(countBattle + " battle");
		Integer countAutobotWinners = (int) result.stream().filter(t-> t.getStatus() == Status.WINNER &&  t.getTransformer() instanceof Autobot).count();
		Integer countDeceptionWinners = (int) result.stream().filter(t-> t.getStatus() == Status.WINNER &&  t.getTransformer() instanceof Deception).count();
		if (countAutobotWinners > countDeceptionWinners) {
			logicPrint(result, Description.AUTOBOT, Description.DECEPTION);
		}
		
		else if (countAutobotWinners < countDeceptionWinners) {
			logicPrint(result, Description.DECEPTION, Description.AUTOBOT);
		}


	}

	private static void logicPrint(List<Result> result, Description winning, Description loser) {
		String losingSurviverName = result.stream()
				.filter(t -> t.getStatus() == Status.SURVIVOR && t.getTransformer().getDescription() == loser)
				.map(l -> l.getTransformer().getName()).collect(Collectors.joining(", "));
		System.out.println("Survivors from the losing team (" + loser.label() + ") : " + losingSurviverName);
		String winningNames = result.stream()
				.filter(t -> t.getStatus() == Status.WINNER && t.getTransformer().getDescription() == winning)
				.map(l -> l.getTransformer().getName()).collect(Collectors.joining(", "));

		System.out.println("Winning team (" + winning.label() + ") : " + winningNames);

	}
}
