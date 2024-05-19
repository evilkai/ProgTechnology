package javatestframe.windows;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import javatestframe.BaseWin;

// Класс для представления ребра графа
class GraphEdge {
    String destinationVertex; // Вершина назначения
    int weight; // Вес ребра

    public GraphEdge(String destinationVertex, int weight) {
        this.destinationVertex = destinationVertex;
        this.weight = weight;
    }
}

public class GraphWindow extends BaseWin {

    private JComboBox<String> vertexComboBox;
    private JComboBox<String> dependencyComboBox;
    private JTextField weightField;
    private JTextArea outputArea;
    private List<String> vertices;
    private Map<String, List<GraphEdge>> graph;
    private int vertexCounter;

    public GraphWindow(String name, Point location) {
        super(name);
        
        this.setLocation(location);
        
        vertices = new ArrayList<>();
        graph = new HashMap<>();
        vertexCounter = 1; // Начинаем счетчик с 1
    }

    @Override
    public void setButton() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        
        JButton addVertexButton = new JButton("Add Vertex");
        addVertexButton.addActionListener(e -> {
            String vertex = String.valueOf(vertexCounter++); // Преобразуем счетчик в строку и увеличиваем его
            vertices.add(vertex);
            graph.put(vertex, new ArrayList<>());
            vertexComboBox.addItem(vertex);
            dependencyComboBox.addItem(vertex); // Добавляем вершину в комбо-бокс зависимостей
            System.out.println("Added Vertex: " + vertex);
            updateGraphOutput(); // Обновляем вывод графа
        });

        JButton addDependencyButton = new JButton("<html><div align=center>Add<br>Dependency</div></html>");
        addDependencyButton.addActionListener(e -> {
            String selectedVertex = (String) vertexComboBox.getSelectedItem();
            String dependency = (String) dependencyComboBox.getSelectedItem();
            String weight = weightField.getText();
            if (selectedVertex != null && dependency != null && !weight.isEmpty() && vertices.contains(dependency)) {
                // Добавляем зависимость и вес
                graph.get(selectedVertex).add(new GraphEdge(dependency, Integer.parseInt(weight)));
                System.out.println("Added Dependency from " + selectedVertex + " to " + dependency + " (Weight: " + weight + ")");
                weightField.setText("");
                updateGraphOutput(); // Обновляем вывод графа
            }
        });

        JButton calculateShortestPathButton = new JButton("<html><div align=center>Calculate Shortest<br>Path</div></html>");
        calculateShortestPathButton.addActionListener(e -> {
            String sourceVertex = (String) vertexComboBox.getItemAt(0); // Предполагаем, что первая вершина - исходная
            String destinationVertex = (String) vertexComboBox.getItemAt(vertexComboBox.getItemCount() - 1); // Предполагаем, что последняя вершина - конечная
            List<String> shortestPath = calculateShortestPath(sourceVertex, destinationVertex);
            System.out.println("Shortest Path: " + shortestPath);
        });
        addVertexButton.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonPanel.add(addVertexButton);
        addDependencyButton.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonPanel.add(addDependencyButton);
        calculateShortestPathButton.setFont(new Font("Arial", Font.PLAIN,15));
        buttonPanel.add(calculateShortestPathButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public JPanel setTop(JPanel layout) {
        JLabel titleLabel = new JLabel("Graph Input");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        layout.add(checkBoxOption);
        layout.add(titleLabel, BorderLayout.NORTH);
        return layout;
    }

    @Override
    public JPanel setCenter(JPanel layout) {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(7, 1));

        JLabel selectVertexLabel = new JLabel("Select Vertex:");
        vertexComboBox = new JComboBox<>();

        JLabel dependencyLabel = new JLabel("Select Dependency:");
        dependencyComboBox = new JComboBox<>();

        JLabel weightLabel = new JLabel("Weight:");
        weightField = new JTextField();

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
        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        layout.add(scrollPane, BorderLayout.CENTER);
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

    // Метод для обновления вывода графа
    private void updateGraphOutput() {
        StringBuilder output = new StringBuilder();
        for (String vertex : vertices) {
            output.append(vertex).append(": ");
            List<GraphEdge> edges = graph.get(vertex);
            if (edges != null && !edges.isEmpty()) {
                for (GraphEdge edge : edges) {
                    output.append(edge.destinationVertex).append(" (Weight: ").append(edge.weight).append("), ");
                }
                output.setLength(output.length() - 2); // Удаляем лишнюю запятую и пробел в конце строки
            }
            output.append("\n");
        }
        String outputString = output.toString();
        outputArea.setText(outputString); // Устанавливаем текстовое содержимое
        System.out.println(outputString); // Выводим в консоль
    }

    // Метод для расчета кратчайшего пути с помощью алгоритма Дейкстры
    private List<String> calculateShortestPath(String sourceVertex, String destinationVertex) {
        Map<String, Integer> distances = new HashMap<>(); // Хранит расстояния от исходной вершины до всех остальных
        Map<String, String> previousVertices = new HashMap<>(); // Хранит предыдущие вершины на кратчайшем пути
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get)); // Очередь с приоритетами для выбора следующей вершины для рассмотрения

        // Инициализация расстояний и предыдущих вершин
                // Инициализация расстояний и предыдущих вершин
        for (String vertex : vertices) {
            distances.put(vertex, Integer.MAX_VALUE); // Изначально все расстояния до вершин бесконечны
            previousVertices.put(vertex, null); // Изначально нет предыдущих вершин
            queue.add(vertex); // Добавляем все вершины в очередь
        }
        distances.put(sourceVertex, 0); // Расстояние от начальной вершины до неё самой равно 0

        // Пока очередь не пуста
        while (!queue.isEmpty()) {
            String currentVertex = queue.poll(); // Извлекаем вершину с наименьшим расстоянием
            if (currentVertex.equals(destinationVertex)) {
                break; // Если достигли конечной вершины, прекращаем процесс
            }
            List<GraphEdge> edges = graph.get(currentVertex); // Получаем все рёбра для текущей вершины
            if (edges != null) {
                for (GraphEdge edge : edges) {
                    int alternativeDistance = distances.get(currentVertex) + edge.weight; // Рассчитываем альтернативное расстояние
                    if (alternativeDistance < distances.get(edge.destinationVertex)) {
                        distances.put(edge.destinationVertex, alternativeDistance); // Обновляем расстояние
                        previousVertices.put(edge.destinationVertex, currentVertex); // Устанавливаем текущую вершину как предыдущую на кратчайшем пути
                        queue.remove(edge.destinationVertex); // Удаляем и добавляем обратно вершину для обновления её приоритета в очереди
                        queue.add(edge.destinationVertex);
                    }
                }
            }
        }

        // Восстанавливаем кратчайший путь
        List<String> shortestPath = new ArrayList<>();
        String currentVertex = destinationVertex;
        int totalWeight = 0; // Добавляем переменную для суммарного веса пути
        while (currentVertex != null) {
            shortestPath.add(0, currentVertex); // Вставляем вершину в начало списка
            String previousVertex = previousVertices.get(currentVertex); // Получаем предыдущую вершину
            if (previousVertex != null) {
                // Находим ребро между текущей и предыдущей вершиной
                List<GraphEdge> edges = graph.get(previousVertex);
                if (edges != null) {
                    for (GraphEdge edge : edges) {
                        if (edge.destinationVertex.equals(currentVertex)) {
                            // Увеличиваем суммарный вес на вес текущего ребра
                            totalWeight += edge.weight;
                            break;
                        }
                    }
                }
            }
            currentVertex = previousVertex; // Переходим к предыдущей вершине
        }

        System.out.println("Total Weight: " + totalWeight); // Выводим суммарный вес пути
        return shortestPath;
    }

    @Override
    public void onUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Point getLocationWindow() {
        return this.getLocation();
    }
}
