package task_1;

import java.util.Arrays;
import java.util.List;

public class BuildCastles {

	public static int getNumberOfCastles(List<Integer> land) {
		if (land == null || land.isEmpty() || land.size() < 3) {
			return 0;
		}
		return countValleyPeak(land, 1, 0);
	}

	public static int countValleyPeak(List<Integer> land, int startIndex, int count) {
		if (startIndex >= land.size() - 1) {
			return count;
		}
		int nextIndex = startIndex + 1;
		Integer preceding = land.get(startIndex - 1);
		Integer target = land.get(startIndex);
		Integer following = land.get(nextIndex);
		// find valley
		if (preceding > target && target < following) {
			count++;

		} else if (preceding > target && target == following) {
			while (target == following) {
				following = land.get(++nextIndex);
			}
			if (preceding > target && target < following) {
				count++;
			}
		}
		// find peak
		if (preceding < target && target > following) {
			count++;

		} else if (preceding < target && target == following) {
			while (target == following) {
				following = land.get(++nextIndex);
			}
			if (preceding < target && target > following) {
				count++;
			}
		}

		return countValleyPeak(land, nextIndex + 1, count);
	}

	// [2,6,6,6,3] peak
	// [6,1,4] valley
	public static void main(String[] args) {

		List<Integer> arrayOfPeakAndValley = Arrays.asList(2, 6, 6, 3, 6, 1, 4);

		System.out.println(getNumberOfCastles(arrayOfPeakAndValley));

	}
}
