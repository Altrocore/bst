import React from 'react';
import ParentComponent from './components/ParentComponent';
import './App.css';

const App = () => {
    return (
        <div className="app">
            <h1>Binary Search Tree Visualization</h1>
            <ParentComponent />
        </div>
    );
};

export default App;
