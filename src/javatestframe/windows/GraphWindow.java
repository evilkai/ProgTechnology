package javatestframe.windows;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;
import javatestframe.BaseWin;

class GraphEdge {
    String destinationVertex;
    int weight;

    public GraphEdge(String destinationVertex, int weight) {
        this.destinationVertex = destinationVertex;
        this.weight = weight;
    }
}

public class GraphWindow extends BaseWin {

    private JComboBox<String> vertexComboBox;
    private JComboBox<String> dependencyComboBox;
    private JFormattedTextField weightField;
    private JTextArea outputArea;
    private List<String> vertices;
    private Map<String, List<GraphEdge>> graph;
    private int vertexCounter;

    public GraphWindow(String name, Point location) {
        super(name);
        this.setLocation(location);
        vertices = new ArrayList<>();
        graph = new HashMap<>();
        vertexCounter = 1;
    }
    
    private boolean isEdgeExists(String vertexA, String vertexB) {
        // Проверяем ребро от вершины A к вершине B
        List<GraphEdge> edgesFromA = graph.get(vertexA);
        if (edgesFromA != null) {
            for (GraphEdge edge : edgesFromA) {
                if (edge.destinationVertex.equals(vertexB)) {
                    return true;
                }
            }
        }
        // Проверяем ребро от вершины B к вершине A
        List<GraphEdge> edgesFromB = graph.get(vertexB);
        if (edgesFromB != null) {
            for (GraphEdge edge : edgesFromB) {
                if (edge.destinationVertex.equals(vertexA)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void setButton() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));

        JButton addVertexButton = new JButton("Добавить вершину");
        addVertexButton.addActionListener(e -> {
            String vertex = String.valueOf(vertexCounter++);
            vertices.add(vertex);
            graph.put(vertex, new ArrayList<>());
            vertexComboBox.addItem(vertex);
            dependencyComboBox.addItem(vertex);
            updateGraphOutput();
        });

        JButton addDependencyButton = new JButton("<html><div align=center>Добавить<br>зависимость</div></html>");
        addDependencyButton.addActionListener(e -> {
        String selectedVertex = (String) vertexComboBox.getSelectedItem();
        String dependency = (String) dependencyComboBox.getSelectedItem();
        String weightText = weightField.getText();
        // Проверяем, что выбранные вершины не равны друг другу
        if (selectedVertex != null && dependency != null && !selectedVertex.equals(dependency) && !weightText.isEmpty() && vertices.contains(dependency)) {
            // Проверяем, существует ли уже ребро между выбранными вершинами
            if (!isEdgeExists(selectedVertex, dependency)) {
                // Если ребра еще нет, добавляем его
                int weight = Integer.parseInt(weightText);
                graph.get(selectedVertex).add(new GraphEdge(dependency, weight));
                weightField.setText("");
                updateGraphOutput();
            } else {
                // Если ребро уже существует, выводим сообщение об ошибке
                JOptionPane.showMessageDialog(null, "Ребро между выбранными вершинами уже существует!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Если выбраны одинаковые вершины или какая-то из вершин не выбрана, выводим сообщение об ошибке
            JOptionPane.showMessageDialog(null, "Выберите разные вершины и укажите вес!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    });

        JButton calculateShortestPathButton = new JButton("<html><div align=center>Найти кратчайший<br>путь</div></html>");
        calculateShortestPathButton.addActionListener(e -> {
            String sourceVertex = (String) vertexComboBox.getItemAt(0);
            String destinationVertex = (String) vertexComboBox.getItemAt(vertexComboBox.getItemCount() - 1);
            List<String> shortestPath = calculateShortestPath(sourceVertex, destinationVertex);
            int totalWeight = calculateTotalWeight(shortestPath);
            String result = "Кратчайший путь: " + shortestPath + "\nСуммарный вес: " + totalWeight;
            showResultWindow("Кратчайший путь", result);
        });

        JButton calculateLongestPathButton = new JButton("<html><div align=center>Найти самый<br>длинный путь</div></html>");
        calculateLongestPathButton.addActionListener(e -> {
            String sourceVertex = (String) vertexComboBox.getItemAt(0);
            String destinationVertex = (String) vertexComboBox.getItemAt(vertexComboBox.getItemCount() - 1);
            List<String> longestPath = calculateLongestPath(sourceVertex, destinationVertex);
            int totalWeight = calculateTotalWeight(longestPath);
            String result = "Самый длинный путь: " + longestPath + "\nСуммарный вес: " + totalWeight;
            showResultWindow("Самый длинный путь", result);
        });

        addVertexButton.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonPanel.add(addVertexButton);
        addDependencyButton.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonPanel.add(addDependencyButton);
        calculateShortestPathButton.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonPanel.add(calculateShortestPathButton);
        calculateLongestPathButton.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonPanel.add(calculateLongestPathButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public JPanel setTop(JPanel layout) {
        
        // CheckBox
        checkBoxOption.setBorder(null);
        layout.add(checkBoxOption);
        JLabel titleLabel = new JLabel("Добавьте данные о графе");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        layout.add(titleLabel, BorderLayout.NORTH);
        return layout;
    }

    @Override
    public JPanel setCenter(JPanel layout) {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(7, 1));

        JLabel selectVertexLabel = new JLabel("Вершина А:");
        vertexComboBox = new JComboBox<>();

        JLabel dependencyLabel = new JLabel("Вершина Б:");
        dependencyComboBox = new JComboBox<>();

        JLabel weightLabel = new JLabel("Укажите вес пути A -> Б:");

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        weightField = new JFormattedTextField(formatter);

        centerPanel.add(selectVertexLabel);
        centerPanel.add(vertexComboBox);
        centerPanel.add(dependencyLabel);
        centerPanel.add(dependencyComboBox);
        centerPanel.add(weightLabel);
        centerPanel.add(weightField);

        layout.add(centerPanel, BorderLayout.CENTER);
        return layout;
    }

    @Override
    public JPanel setBottom(JPanel layout) {
        JPanel bottomPanel = new JPanel(new BorderLayout());

        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        layout.add(bottomPanel, BorderLayout.CENTER);
        add(layout, BorderLayout.SOUTH);
        return layout;
    }

    @Override
    public void onClose() {
        System.out.println("Closing GraphWindow");
    }

    @Override
    public BaseWin getWindow() {
        return this;
    }

    @Override
    public void init() {
        super.init();
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        setTop(topPanel);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        setCenter(centerPanel);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        setBottom(bottomPanel);
        add(bottomPanel, BorderLayout.SOUTH);

        setButton();
    }

    private void updateGraphOutput() {
        StringBuilder output = new StringBuilder();
        for (String vertex : vertices) {
            output.append(vertex).append(": ");
            List<GraphEdge> edges = graph.get(vertex);
            if (edges != null && !edges.isEmpty()) {
                for (GraphEdge edge : edges) {
                    output.append(edge.destinationVertex).append(" (Weight: ").append(edge.weight).append("), ");
                }
                output.setLength(output.length() - 2);
            }
            output.append("\n");
        }
        String outputString = output.toString();
        outputArea.setText(outputString);
        System.out.println(outputString);
    }

        private List<String> calculateShortestPath(String sourceVertex, String destinationVertex) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousVertices = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (String vertex : vertices) {
            distances.put(vertex, Integer.MAX_VALUE);
            previousVertices.put(vertex, null);
            queue.add(vertex);
        }
        distances.put(sourceVertex, 0);

        while (!queue.isEmpty()) {
            String currentVertex = queue.poll();
            if (currentVertex.equals(destinationVertex)) {
                break;
            }
            List<GraphEdge> edges = graph.get(currentVertex);
            if (edges != null) {
                for (GraphEdge edge : edges) {
                    int alternativeDistance = distances.get(currentVertex) + edge.weight;
                    if (alternativeDistance < distances.get(edge.destinationVertex)) {
                        distances.put(edge.destinationVertex, alternativeDistance);
                        previousVertices.put(edge.destinationVertex, currentVertex);
                        queue.remove(edge.destinationVertex);
                        queue.add(edge.destinationVertex);
                    }
                }
            }
        }

        List<String> shortestPath = new ArrayList<>();
        String currentVertex = destinationVertex;
        while (currentVertex != null) {
            shortestPath.add(0, currentVertex);
            currentVertex = previousVertices.get(currentVertex);
        }

        return shortestPath;
    }

    private List<String> calculateLongestPath(String sourceVertex, String destinationVertex) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousVertices = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get).reversed());

        for (String vertex : vertices) {
            distances.put(vertex, Integer.MIN_VALUE);
            previousVertices.put(vertex, null);
            queue.add(vertex);
        }
        distances.put(sourceVertex, 0);

        while (!queue.isEmpty()) {
            String currentVertex = queue.poll();
            if (currentVertex.equals(destinationVertex)) {
                break;
            }
            List<GraphEdge> edges = graph.get(currentVertex);
            if (edges != null) {
                for (GraphEdge edge : edges) {
                    int alternativeDistance = distances.get(currentVertex) + edge.weight;
                    if (alternativeDistance > distances.get(edge.destinationVertex)) {
                        distances.put(edge.destinationVertex, alternativeDistance);
                        previousVertices.put(edge.destinationVertex, currentVertex);
                        queue.remove(edge.destinationVertex);
                        queue.add(edge.destinationVertex);
                    }
                }
            }
        }

        List<String> longestPath = new ArrayList<>();
        String currentVertex = destinationVertex;
        while (currentVertex != null) {
            longestPath.add(0, currentVertex);
            currentVertex = previousVertices.get(currentVertex);
        }

        return longestPath;
    }

    private int calculateTotalWeight(List<String> path) {
        int totalWeight = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String currentVertex = path.get(i);
            String nextVertex = path.get(i + 1);
            List<GraphEdge> edges = graph.get(currentVertex);
            if (edges != null) {
                for (GraphEdge edge : edges) {
                    if (edge.destinationVertex.equals(nextVertex)) {
                        totalWeight += edge.weight;
                        break;
                    }
                }
            }
        }
        return totalWeight;
    }

    private void showResultWindow(String title, String result) {
        JFrame resultFrame = new JFrame(title);
        resultFrame.setSize(400, 200);
        resultFrame.setLocationRelativeTo(null);
        JTextArea resultArea = new JTextArea(result);
        resultArea.setEditable(false);
        resultFrame.add(new JScrollPane(resultArea));
        resultFrame.setVisible(true);
    }

    @Override
    public void onUpdate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Point getLocationWindow() {
        return this.getLocation();
    }
}
