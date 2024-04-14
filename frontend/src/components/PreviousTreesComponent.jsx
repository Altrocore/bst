import React, { useEffect, useState } from 'react';

const PreviousTreesComponent = () => {
    const [previousTrees, setPreviousTrees] = useState([]);
    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            setIsLoading(true);
            try {
                const response = await fetch('/api/previous-trees');
                if (!response.ok) {
                    throw new Error('Failed to fetch previous trees');
                }
                const data = await response.json();
                setPreviousTrees(data);
            } catch (error) {
                setError(error);
            } finally {
                setIsLoading(false);
            }
        };
        fetchData();
    }, []);

    return (
        <div className="previous-trees">
            <h2>Previous Trees</h2>
            {isLoading && <p>Loading...</p>}
            {error && <p>Error: {error.message}</p>}
            {!isLoading && !error && (
                <ul>
                    {previousTrees.map((tree, index) => (
                        <li key={index}>
                            <p>Tree #{index + 1}</p>
                            <p>Input Numbers: {tree.numbers.join(', ')}</p>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default PreviousTreesComponent