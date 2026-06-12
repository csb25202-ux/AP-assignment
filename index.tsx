import { useState } from 'react';
import { StyleSheet, Text, View, TouchableOpacity } from 'react-native';

export default function Index() {
  // 1. State
  const [count, setCount] = useState(0);
  const [isDarkMode, setIsDarkMode] = useState(false); // New state for theme

  // 2. Logic
  const handleIncrement = () => setCount(count + 1);
  
  const handleDecrement = () => {
    if (count > 0) {
      setCount(count - 1);
    }
  };
  
  const handleReset = () => setCount(0);

  const toggleTheme = () => {
    setIsDarkMode(!isDarkMode); // Flips false to true, or true to false
  };

  // 3. Dynamic Styles using Ternary Operators
  // If isDarkMode is true, use the first color. Otherwise, use the second color.
  const dynamicBackground = { backgroundColor: isDarkMode ? '#1e1e1e' : '#ffffff' };
  const dynamicText = { color: isDarkMode ? '#ffffff' : '#000000' };
  const dynamicButton = { backgroundColor: isDarkMode ? '#333333' : '#e0e0e0' };

  // 4. UI Layout
  return (
    <View style={[styles.container, dynamicBackground]}>
      
      {/* Theme Toggle Button */}
      <TouchableOpacity style={[styles.themeToggleBtn, dynamicButton]} onPress={toggleTheme}>
        <Text style={[styles.themeToggleText, dynamicText]}>
          {isDarkMode ? '☀️ Switch to Light Mode' : '🌙 Switch to Dark Mode'}
        </Text>
      </TouchableOpacity>
      
      {/* The Big Number */}
      <Text style={[styles.counterText, dynamicText]}>{count}</Text>
      
      {/* Side-by-side Buttons */}
      <View style={styles.buttonRow}>
        <TouchableOpacity style={[styles.button, dynamicButton]} onPress={handleDecrement}>
          <Text style={[styles.buttonText, dynamicText]}>- Decrement</Text>
        </TouchableOpacity>

        <TouchableOpacity style={[styles.button, dynamicButton]} onPress={handleIncrement}>
          <Text style={[styles.buttonText, dynamicText]}>+ Increment</Text>
        </TouchableOpacity>
      </View>

      {/* Reset Button */}
      <TouchableOpacity style={styles.resetButton} onPress={handleReset}>
        <Text style={styles.resetButtonText}>Reset</Text>
      </TouchableOpacity>

    </View>
  );
}

// 5. Base Styling (Flexbox)
const styles = StyleSheet.create({
  container: {
    flex: 1, 
    justifyContent: 'center', 
    alignItems: 'center', 
  },
  themeToggleBtn: {
    position: 'absolute', // Puts the button at the top of the screen
    top: 60,
    padding: 12,
    borderRadius: 8,
    borderWidth: 1,
    borderColor: '#888888',
  },
  themeToggleText: {
    fontSize: 16,
    fontWeight: 'bold',
  },
  counterText: {
    fontSize: 100,
    fontWeight: 'bold',
    marginBottom: 40,
  },
  buttonRow: {
    flexDirection: 'row', 
    gap: 15, 
    marginBottom: 20,
  },
  button: {
    padding: 15,
    borderRadius: 8,
  },
  buttonText: {
    fontSize: 18,
    fontWeight: 'bold',
  },
  resetButton: {
    backgroundColor: '#ff4757', 
    padding: 15,
    paddingHorizontal: 40,
    borderRadius: 8,
    marginTop: 10,
  },
  resetButtonText: {
    color: '#ffffff',
    fontSize: 18,
    fontWeight: 'bold',
  },
});

// cd .\counter-app\
//  npx expo start -c