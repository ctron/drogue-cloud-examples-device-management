import React from 'react'
import {Caption, TableComposable, Tbody, Td, Th, Thead, Tr} from "@patternfly/react-table";

const Devices = ({ devices }) => {
    return (
        <React.Fragment>
            <TableComposable>
                <Thead>
                    <Tr>
                        <Th key={0}>Name</Th>
                    </Tr>
                </Thead>
                <Tbody>
                    {devices.map((device, idx) => (
                        <Tr key={idx}>
                            <Td key="{idx}_name" dataLabel="Name">{device.id}</Td>
                        </Tr>
                    ))}
                </Tbody>
            </TableComposable>
        </React.Fragment>
    )
};

export default Devices
