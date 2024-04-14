import React from 'react';

const InputComponent = ({ inputNumbers, setInputNumbers, onSubmit, onShowPrevious }) => {
    return (
        <div className="input-section">
            <input
                type="text"
                value={inputNumbers}
                onChange={(e) => setInputNumbers(e.target.value)}
                placeholder="Enter comma-separated numbers"
            />
            <button onClick={onSubmit}>Submit</button>
            <button onClick={onShowPrevious}>Show Previous</button>
        </div>
    );
};

export default InputComponent;
