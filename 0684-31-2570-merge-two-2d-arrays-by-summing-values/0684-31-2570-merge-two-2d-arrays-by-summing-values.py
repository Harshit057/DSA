class Solution:
    def mergeArrays(self, nums1, nums2):
        merged_dict = {}

        # Add values from nums1
        for id1, val1 in nums1:
            merged_dict[id1] = merged_dict.get(id1, 0) + val1

        # Add values from nums2
        for id2, val2 in nums2:
            merged_dict[id2] = merged_dict.get(id2, 0) + val2

        # Convert to sorted list of lists
        return sorted([[k, v] for k, v in merged_dict.items()])
