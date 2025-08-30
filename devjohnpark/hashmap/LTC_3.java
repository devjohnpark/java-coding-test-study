class Solution {
    // 문제 정의: 주어진 문자여에서 중복되지 않는 문자로 구성된 가장긴 substring을 구해라. -> 연속된 문자열에서 동일한 문자가 있으면 안된다.
    // 시간복잡도: 50000이므로 O(nlogn) 이내로 풀어야한다.
    // 부르트 포스
    // 문자열의 문자를 순회중에 

    // 핵심 문제 풀이
    // 슬라이딩 윈도우 + HashMap (최적화된 버전)
    // 문자열 구간 지정
    // 중복 확인을 위해 문자를 순회하면서 hashmap에 <문자, 인덱스> 저장
    // 오른쪽 포인터를 이동하면서 hashmap에서 중복되는 문자가 있는지 확인
    // hashmap에서 가져온 문자의 인덱스가 왼쪽 포인터보다 작으면 true
    // hashmap에서 가져온 문자의 인덱스가 왼쪽 포인터보다 작으면 false -> 구간 변경 -> 왼쪽 포인터를 현재 지정된 인덱스로 이동, 오른쪽 포인터는 왼쪽 포인터 +1
    // 문제 다시 봐야됨
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 1;
        for (int right = 0; right < length; right++) {
            char c = s.charAt(right);
            Integer idx = map.get(c);
            if (idx != null && idx >= left) {
                // 구간 업데이트
                // rigth가 아니라 hashmap에 중복 저장된 인덱스의 바로 다음 인덱스부터 left로 시작해야한다. left = right (x)
                // ex) pwewki에서 3번 인덱스 w 중복될때, e부터 시작해야함
                left = idx + 1;
            } 
            map.put(c, right); // 다음 구간에서 중복되는 값 찾기 위해 저장
            maxLen = Math.max(maxLen, right - left + 1); // 문자열 길이 업데이트
        }
        return maxLen;
    }
}
