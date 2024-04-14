import React, { useEffect, useState } from 'react';

const TreeVisualizationComponent = ({ inputNumbers }) => {
    const [treeData, setTreeData] = useState(null);
    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            setIsLoading(true);
            try {
                const response = await fetch('/api/process-numbers', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(inputNumbers.split(',').map(Number)), // Convert to array of numbers
                });
                if (!response.ok) {
                    throw new Error('Failed to fetch tree');
                }
                const data = await response.json();
                setTreeData(data);
            } catch (error) {
                setError(error);
            } finally {
                setIsLoading(false);
            }
        };

        if (inputNumbers) {
            fetchData();
        }
    }, [inputNumbers]);

    return (
        <div>
            {isLoading && <p>Loading tree...</p>}
            {error && <p>Error: {error.message}</p>}
            {!isLoading && !error && treeData && (
                <pre>
                    {JSON.stringify(treeData, null, 2)}
                </pre>
            )}
        </div>
    );
};

export default TreeVisualizationComponent;