package com.suri.common;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

        public int val;
        public List<GraphNode> neighbors;

        public GraphNode(int val, ArrayList arrayList) {
                this.val = val;
                this.neighbors = arrayList;
        }
}
