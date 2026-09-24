import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree = number of prerequisites
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];

            // preCourse -> course
            graph.get(preCourse).add(course);

            indegree[course]++;
        }

        // Add courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Store course order
        int[] result = new int[numCourses];
        int index = 0;

        // BFS
        while (!queue.isEmpty()) {
            int course = queue.poll();

            result[index] = course;
            index++;

            // Remove this course as a prerequisite
            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;

                // No more prerequisites
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // If we couldn't take all courses, there is a cycle
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}
