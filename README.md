<h1 align="center">Sudoku Game 🧠</h1>

A classic Sudoku puzzle built with **Java Swing**, offering an elegant GUI for entering digits, checking solutions, and restarting the grid. Designed for logic game lovers who enjoy a clean and interactive experience on desktop. 🎯

---

# Screenshots 📸

![Screenshot 2025-07-01 160705](https://github.com/user-attachments/assets/df340dd1-e922-4a32-a7b0-f027d3e6e57a)

---

# Requirements 🛠️

1. **Programming Language**: Java 8+ ☕

2. **Libraries Used**:
   - Java Swing (for building the GUI) 🎨
   - Java AWT (for layout and events)

3. **Development Tools**:
   - IntelliJ IDEA / Eclipse / NetBeans (optional but recommended) 🛠️
   - JDK installed and configured in PATH

---

# Features ✨

1. **Pre-filled Sudoku Board** 🔢  
   - Cells with preset values are shaded gray and cannot be edited.

2. **Editable User Inputs** ✍️  
   - White cells allow manual input of numbers using the keyboard.

3. **Check Button** ✅  
   - Verifies current user entries (if validation logic is implemented).

4. **Reset Button** 🔄  
   - Clears all editable cells and resets the board to its initial state.

5. **Structured GUI** 🧱  
   - Utilizes GridLayout and event listeners to manage a responsive 9×9 board.

6. **Visual Cues** 👁️  
   - Thick black borders distinguish 3×3 subgrids to improve clarity.

---

# Installation 🚀

### Clone the repository:
```bash
git clone https://github.com/your-username/sudoku-java-swing.git
cd sudoku-java-swing
```

### Compile the game:
```bash
javac SudokuGame.java
```

### Run the game:
```
java SudokuGame
```
---

# How to Play 🎯

1. **Start the Game**  
   - Launch the app using your terminal or IDE.
   - The 9×9 Sudoku board will be displayed in a GUI window.

2. **Fill in the Blanks**  
   - Click on any **white (editable)** cell and type a digit from **1 to 9**.
   - **Gray cells** contain pre-filled puzzle values and cannot be changed.

3. **Use Buttons**
   - **Check** ✅: Validates the current board state (functionality can be extended).
   - **Reset** 🔄: Restores the puzzle to its original unsolved state.

4. **Sudoku Rules**
   - Each row, column, and 3×3 subgrid must contain all digits from **1 to 9**.
   - No repetitions are allowed in any row, column, or 3×3 box.

---
# Compatibility 🌐

- ✅ Java 8 and above
- 💻 Compatible with Windows, macOS, and Linux
- 🧪 Tested on IntelliJ IDEA and Eclipse
