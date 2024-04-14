import React, { useState } from 'react';
import InputComponent from './InputComponent';
import TreeVisualizationComponent from './TreeVisualizationComponent';
import PreviousTreesComponent from './PreviousTreesComponent';

const ParentComponent = () => {
    const [inputNumbers, setInputNumbers] = useState('');
    const [showPreviousTrees, setShowPreviousTrees] = useState(false);

    const handleSubmit = () => {
        if (inputNumbers) {
            setShowPreviousTrees(false);
        }
    };

    const handleShowPrevious = () => {
        setShowPreviousTrees(true);
    };

    return (
        <div>
            <InputComponent
                inputNumbers={inputNumbers}
                setInputNumbers={setInputNumbers}
                onSubmit={handleSubmit}
                onShowPrevious={handleShowPrevious}
            />
            {!showPreviousTrees && <TreeVisualizationComponent inputNumbers={inputNumbers} />}
            {showPreviousTrees && <PreviousTreesComponent />}
        </div>
    );
};

export default ParentComponent;
