package main.java.janhen.swordoffer.a_base.problem3;

import java.util.BitSet;

@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class Solution2 {
	public boolean duplicate(int nums[], int length, int[] duplication) {
		BitSet occur = new BitSet(length);
		for (int i = 0; i < length; i++) {
			int val = nums[i];
			if (occur.get(val)) {
				duplication[0] = val;
				return true;
			}
			occur.set(val);
		}
		return false;
	}
}