package com.davis.course;

import java.util.concurrent.RecursiveTask;

public class SumCalculator extends RecursiveTask<Integer> {

	private final int SPLIT_THRESHOLD = 4;
	
	private final Integer[] nums;
	private final int start;
	private final int end;

	public SumCalculator(Integer[] nums) {
		this(nums, 0, nums.length);
	}

	public SumCalculator(Integer[] nums, int start, int end) {
		this.nums = nums;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {

		int partSum = 0;
	
		if ((end - start) < SPLIT_THRESHOLD) {
			
			for (int i = start; i < end; i++)
				partSum += nums[i];
			
			return partSum;
		}
		else {
			
			final int mid = (end - start)/2 + start;

			final SumCalculator firstCalc = 
				new SumCalculator(nums, start, mid);
			firstCalc.fork();

			final SumCalculator secondCalc = 
				new SumCalculator(nums, mid, end);
			partSum = secondCalc.compute();
			
			return firstCalc.join() + partSum;
		}		
	}
}